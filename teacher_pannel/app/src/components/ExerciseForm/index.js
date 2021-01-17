import React, { Fragment, useState } from 'react';
import axios from 'axios';
import { useCookies } from 'react-cookie';
import { API_URL } from '../../configuration';

const ExerciseForm = ({ exercise, createNew, refresh, cancelCreating }) => {
    const [cookies] = useCookies(["jwt"]);
    const [disabled, setDisabled] = useState(exercise ? true : false);
    const [question, setQuestion] = useState((exercise && exercise.question) || "");
    const [correctAnswers, setCorrectAnswers] = useState((exercise && exercise.correctAnswers) || "");
    const [incorrectAnswers, setIncorrectAnswers] = useState((exercise && exercise.incorrectAnswers) || "");

    const saveExercise = () => {
        if (exercise) {
            axios({
                method: "PUT",
                url: `${API_URL}/exercises/${exercise.id}`,
                headers: {
                    "Content-Type": "application/json",
                    Authorization: `Bearer ${cookies.jwt}`
                },
                data: {
                    question: question,
                    correctAnswers: [correctAnswers],
                    incorrectAnswers: incorrectAnswers
                }
            }).then(reponse => {
                refresh();
                alert("Operacja udana");
                setDisabled(true);
            }).catch(error => alert("Coś poszło nie tak \n" + error));
        } else {
            setDisabled(true);
            createNew(question, [correctAnswers], incorrectAnswers);
        }
    }

    const handleIncorreactAnswerChange = (e, index) => {
        let answers = [...incorrectAnswers];
        let answer = { ...answers[index] }
        answer = e.target.value
        answers[index] = answer;
        setIncorrectAnswers(answers);
    }

    const cancel = () => {
        setDisabled(true);
        if (exercise) {
            setQuestion((exercise && exercise.question) || "");
            setCorrectAnswers((exercise && exercise.correctAnswers) || "");
            setIncorrectAnswers((exercise && exercise.incorrectAnswers) || "")
        }
        else {
            cancelCreating();
        }
    }
    console.log(exercise);

    const addIncorrectAnswer = (e) => {
        e.preventDefault();
        let answers = incorrectAnswers.concat(" ");
        setIncorrectAnswers(answers);
    }

    const removeExercise = () => {
        axios({
            method: "DELETE",
            url: `${API_URL}/exercises/${exercise.id}`,
            headers: {
                Authorization: ` Bearer ${cookies.jwt}`
            }
        }).then(response => {
            alert("operacja udana");
            refresh();
        }).catch(error => {
            alert("coś poszło nie tak\n" + error);
        })
    }

    return (
        <div style={{ border: "1px solid black", margin: "20px 0", padding: "20px" }}>
            <form style={{ display: 'flex', flexDirection: 'column' }}>
                <label htmlFor="question">Pytanie</label>
                <input value={question} disabled={disabled} id="question" onChange={(e) => setQuestion(e.target.value)} />
                <label htmlFor="correctAnswers">Poprawna odpowiedź</label>
                <input id="correctAnswers" disabled={disabled} value={correctAnswers} onChange={(e) => setCorrectAnswers(e.target.value)} />
                <span>Niepoprawne odpowiedzi</span>

                {incorrectAnswers && [...incorrectAnswers].map((answer, index) => <input value={answer} disabled={disabled} key={index} onChange={e => handleIncorreactAnswerChange(e, index)} />)}
                {!disabled && <button onClick={addIncorrectAnswer}>Dodaj odpowiedż</button>}
                {/*
                <textarea rows={incorrectAnswers.length} disabled={disabled} onChange={(e) => setIncorrectAnswers(e.target.value)}
                    name="incorrectAnswers" value={incorrectAnswers.toString().replace(',','\n')} />
                */}
            </form>
            {disabled &&
                <Fragment>
                    <button onClick={() => setDisabled(false)}>Edytuj</button>
                    <button onClick={removeExercise} >Usuń </button>
                </Fragment>
            }
            {!disabled &&
                <Fragment>
                    <button onClick={saveExercise}>Zapisz zmiany</button>
                    <button onClick={cancel}>Anuluj</button>
                </Fragment>
            }
        </div>
    );
};



export default ExerciseForm;