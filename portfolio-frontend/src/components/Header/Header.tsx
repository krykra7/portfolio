import React from 'react';
import "./header.css"
import Buttons from "./Buttons";
import HeaderSocials from "./HeaderSocials";
import Image from "../Image/Image";
import {AppFileType} from "../../api/types/AppFileType";

function Header() {
    return (
        <header>
            <div className="container header__container">
                <h5>Hello I'm</h5>
                <h1>Krystian Krawczyk</h1>
                <h5 className="text-light">Fullstack Developer</h5>
                <Buttons/>
                <HeaderSocials/>
                <div className="me">
                   <Image type={AppFileType.MAIN_PHOTO}/>
                </div>

                <a href="#contact" className="header__scroll-down">Scroll Down</a>
            </div>
        </header>
    );
}

export default Header;
