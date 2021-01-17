import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { useCookies } from 'react-cookie';
import { Redirect, withRouter } from 'react-router-dom';
import { Collapse } from 'react-collapse';
import TeX from '@matejmazur/react-katex';
import { BlockMath, InlineMath } from 'react-katex';

import { API_URL } from '../../configuration';
import ExerciseForm from '../ExerciseForm';

const CourseDetails = ({ match }) => {
    const [cookies, setCookie, removeCookie] = useCookies(["jwt"]);
    const [details, setDetails] = useState(null);
    const [forms, setForms] = useState(null);
    const [canAddNew, setCanAddNew] = useState(true);
    const [redirect, setRedirect] = useState(false);
    const { id } = match.params;

    useEffect(() => {
        if (!details) {
           refresh();
        }
        else if (!forms) {
            setForms(details.exercises.map(exercise => (
                <ExerciseForm exercise={exercise} key={exercise.id} refresh={refresh} />
            )));
        }
    });
    const refresh = () => {
        axios({
            url: `${API_URL}/courses/${id}`,
            headers: {
                Authorization: `Bearer ${cookies.jwt}`
            }
        }).then(response => {
            console.log("refresh");
            console.log(response);
            setDetails(response.data);
            setForms(response.data.exercises.map(exercise => (
                <ExerciseForm exercise={exercise} key={exercise.id} refresh={refresh} />
            )));
        }).catch(error => {
            alert(error);
            removeCookie("jwt");
        });
    }

    const cancelCreatingExercise = () => {
        setCanAddNew(true);
        let list = forms;
        setForms(list);
    }

    const showNewForm = () => {
        let newList = [<ExerciseForm key={0} createNew={saveNewExercise} refresh={refresh} cancelCreating = {cancelCreatingExercise} />].concat(forms);
        setForms(newList);
        setCanAddNew(false)
    };

    const saveNewExercise = (question, correctAnswers, incorrectAnswers) => {
        console.log(correctAnswers);
        axios({
            method: "POST",
            url: `${API_URL}/exercises`,
            headers: {
                "Content-Type": "application/json",
                Authorization: `Bearer ${cookies.jwt}`
            },
            data: {
                question: question,
                correctAnswers: correctAnswers,
                incorrectAnswers: incorrectAnswers,
                courseId: details.id
            }
        }).then(reponse => {
            alert("Operacja udana");
            setCanAddNew(true);
            refresh();
        }).catch(error => alert("Coś poszło nie tak \n" + error));
    }

    const removeCourse = () => {
        axios({
            method: "DELETE",
            url: `${API_URL}/courses/${details.id}`,
            headers: {
                Authorization: `Bearer ${cookies.jwt}`
            }
        }).then(response => {
            alert("Kurs został usuniety");
            setRedirect(true);
        }).catch(error => alert("Coś poszło nie tak \n" + error));

    }

    if(redirect){
        return <Redirect to="/courses"/>
    }

    if (!details) {
        return null;
    }
    return (
        <div style={{ paddingLeft: '50px', paddingRight: '50px' }}>
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center ' }}>
                <h1>{details.name}</h1>
                <div>
                    <button>Edytuj dane kursu</button>
                    <button onClick={removeCourse}>Usuń kurs</button>
                </div>
            </div>
            <button onClick={showNewForm} disabled={!canAddNew}> dodaj zadanie</button>
            {forms}
        </div>
    );
};

export default withRouter(CourseDetails);