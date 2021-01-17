import React, { useState } from 'react';
import { useCookies } from "react-cookie";
import axios from 'axios';
import { API_URL } from '../../configuration';
import { Redirect } from 'react-router-dom';
import {withRouter} from 'react-router-dom';

const LoginPage = ({history}) => {
    const [cookies, setCookie] = useCookies(["jwt"]);
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();
         axios({
            method: 'POST',
            url: `${API_URL}/login`,
            headers: {
                "Content-type": "application/json",
                "Access-Control-Allow-Origin":"*"
            },
            data: {
                login: email,
                password:password
            }
        }).then(response => {
            const jwt = response.headers.jwt;
            setCookie("jwt", jwt, {path:"/"});      
        }).catch(error => {
            // TODO: show message
        });
    };
   if(cookies.jwt){
       return <Redirect to="/"/>
   }
    return (
        <div>
            <h1>Logowanie</h1>
            <div>
                <form onSubmit={handleSubmit}>
                    <input type='email' placeholder='adres email' name="email" onChange={(e) => setEmail(e.target.value)} />
                    <input type='password' placeholder='hasło' name="password" onChange={(e) => setPassword(e.target.value)} />
                    <input type='submit' value='zaloguj się' />
                </form>
            </div>
        </div>
    )
};

export default withRouter(LoginPage);