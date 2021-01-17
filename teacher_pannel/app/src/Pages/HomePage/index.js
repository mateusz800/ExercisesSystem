import axios from 'axios';
import React, { Fragment, useState, useEffect } from 'react';
import { useCookies } from "react-cookie";
import { Redirect } from 'react-router-dom';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import CourseDetails from '../../components/CourseDetails';

import CoursesTable from '../../components/CoursesTable';
import TopBar from '../../components/TopBar';
import { API_URL } from '../../configuration';

const HomePage = () => {
    const [cookies] = useCookies(["jwt"]);
    if (!cookies.jwt) {
        return <Redirect to="/login" />
    }
    return (
        <Fragment>
            <TopBar />
            <Router>
                <Switch>
                    <Route exact path="/courses/:id">
                        <CourseDetails/>
                    </Route>
                    <Route exact path="/courses">
                        <CoursesTable />
                    </Route>
                    <Route path="/">
                        <CoursesTable />
                    </Route>
                </Switch>

            </Router>
        </Fragment>
    );
};

export default HomePage;