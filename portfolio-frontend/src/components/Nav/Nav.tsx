import React, {useState} from 'react';
import "./nav.css"
import {AiOutlineHome, AiOutlineUser, BiBook, BiMessageSquareDetail, RiServiceLine} from "react-icons/all";

function Nav() {
    const [active, setActive] = useState("#")

    const activeClass = (value: string): string => {
        if (value === active) {
            return "active";
        }

        return "";
    }

    return (
        <nav>
            <a href="#"
               className={activeClass("#")}
               onClick={() => setActive("#")}>
                <AiOutlineHome/>
            </a>
            <a href="#about"
               className={activeClass("#about")}
               onClick={() => setActive("#about")}>
                <AiOutlineUser/>
            </a>
            <a href="#experience"
               className={activeClass("#experience")}
               onClick={() => setActive("#experience")}>
                <BiBook/>
            </a>
            <a href="#services"
               className={activeClass("#services")}
               onClick={() => setActive("#services")}>
                <RiServiceLine/>
            </a>
            <a href="#contact"
               className={activeClass("#contact")}
               onClick={() => setActive("#contact")}>
                <BiMessageSquareDetail/>
            </a>
        </nav>
    );
}

export default Nav;
