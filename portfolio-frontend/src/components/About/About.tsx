import React from 'react';
import "./about.css"
import {FaAward, FiUsers, VscFolderLibrary} from "react-icons/all";
import Image from "../Image/Image";
import {AppFileType} from "../../api/types/AppFileType";

type Props = {
    about: string,
    experienceSummary: string;
    clientsSummary: string;
    projectsSummary: string;
}

function About(props: Props) {
    return (
        <section id="about">
            <h5>Get To Know</h5>
            <h2>About Me</h2>

            <div className="container about__container">
                <div className="about__me">
                    <div className="about__me-image">
                        <Image type={AppFileType.ABOUT_ME_PHOTO}/>
                    </div>
                </div>

                <div className="about__content">
                    <div className="about__cards">
                        <article className="about__card">
                            <FaAward className="about__icon"/>
                            <h5>Experience</h5>
                            <small>{props.experienceSummary}</small>
                        </article>
                        <article className="about__card">
                            <FiUsers className="about__icon"/>
                            <h5>Clients</h5>
                            <small>{props.clientsSummary}</small>
                        </article>
                        <article className="about__card">
                            <VscFolderLibrary className="about__icon"/>
                            <h5>Projects</h5>
                            <small>{props.projectsSummary}</small>
                        </article>
                    </div>

                    <p dangerouslySetInnerHTML={{__html: props.about}}/>

                    <a href="#contact" className="btn btn-primary">Let's Talk</a>
                </div>
            </div>
        </section>
    );
}

export default About;
