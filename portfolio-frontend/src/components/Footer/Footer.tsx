import React from 'react';
import "./footer.css"
import {BsLinkedin, FaTwitter, FiInstagram} from "react-icons/all";
import {useApi} from "../../api/common/ApiContext";
import {LinkType} from "../../api/types/LinkType";
import SocialLink from "../common/SocialLink";

function Footer() {
    return (
        <footer id="footer">
            <a href="#" className="footer__logo">Krystian Krawczyk</a>
            <ul className="permalinks">
                <li><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#experience">Experience</a></li>
                <li><a href="#services">Services</a></li>
                <li><a href="#portfolio">Portfolio</a></li>
                {/*<li><a href="#testimonials">Testimonials</a></li>*/}
                <li><a href="#contact">Contact</a></li>
            </ul>

            <div className="footer__socials">

                <SocialLink link="https://www.linkedin.com/in/krystian-krawczyk-647579169/"
                            linkType={LinkType.LINKEDIN}
                            Icon={<BsLinkedin/>}/>
                <SocialLink link="https://www.instagram.com/_bebezao/"
                            linkType={LinkType.INSTAGRAM}
                            Icon={<FiInstagram/>}/>
                <SocialLink link="https://twitter.com/Krystia45869675"
                            linkType={LinkType.TWITTER}
                            Icon={<FaTwitter/>}/>
            </div>

            <div className="footer__copyright">
                <small>&copy; Krystian Krawczyk. All rights reserved</small>
            </div>
        </footer>
    );
}

export default Footer;
