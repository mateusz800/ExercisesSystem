import React from 'react';

import logo from '../../assets/images/logo.png'
import './styles.css'

const TopBar = () => {

    return (
        <div className="container">
            <img src={logo}/>
            <h2><a href="/">AWNM</a></h2>
        </div>
    )
};

export default TopBar;