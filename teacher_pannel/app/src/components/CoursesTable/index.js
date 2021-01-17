
import React, { Fragment, useState, useEffect } from 'react';
import { useCookies } from "react-cookie";
import axios from 'axios';

import TopBar from '../../components/TopBar';
import { API_URL } from '../../configuration';
import CourseForm from '../CourseForm';

const CoursesTable = () => {
    const [cookies, setCookie, removeCookie] = useCookies(["jwt"]);
    const [courses, setCourses] = useState(null);
    const [createNew, setCreateNew] = useState(false);
    useEffect(() => {
        if (!courses) {
            refresh();
        }
    });

    const refresh = () => {
        axios({
            url: `${API_URL}/courses`,
            headers: {
                Authorization: `Bearer ${cookies.jwt}`
            }
        }).then(response => {
            setCourses(response.data.content)
        }).catch(error => {
            removeCookie("jwt");
        });
    }

    const createNewCourse = (name, desc) => {
        axios({
            method: 'POST',
            url: `${API_URL}/courses`,
            headers: {
                Authorization: `Bearer ${cookies.jwt}`,
                "Content-Type": "application/json"
            },
            data: {
                name: name,
                desc: desc
            }
        }).then(response => {
            alert("operacja udana");
            setCreateNew(false);
            refresh();
        }).catch(error => {
            alert("coś poszło nie tak")
            console.log(error);
        });
    }

    const cancelCreatingCourse = () => {
        setCreateNew(false);
    }

    return (
        <div style={{ margin: "10px 50px" }}>
            <button onClick={() => setCreateNew(true)} disabled={createNew}>Stwórz nowy kurs</button>
            {createNew && <CourseForm createNew={createNewCourse} cancel={cancelCreatingCourse} />}
            <table>
                <thead>
                    <th>Nazwa kursu</th>
                </thead>
                <tbody>
                    {courses && courses.map(course => (
                        <tr key={course.id}>
                            <td><a href={`/courses/${course.id}`}>{course.name}</a></td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default CoursesTable;