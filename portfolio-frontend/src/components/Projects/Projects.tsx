import React from 'react';
import "./projects.css"
import {ProjectResponse} from "../../api/response/ProjectResponse";
import Image from "../Image/Image";
import {useApi} from "../../api/common/ApiContext";
import {LinkType} from "../../api/types/LinkType";
import SocialLink from "../common/SocialLink";

type Props = {
    projects: ProjectResponse[];
}

function Projects({projects}: Props) {
    return (
        <section id="portfolio">
            <h5>Projects I worked on</h5>
            <h2>Portfolio</h2>

            <div className="container portfolio__container">
                {
                    projects.map((item, index) => {
                        return (
                            <article key={index} className="portfolio__item">
                                <div className="portfolio__item-image">
                                    <Image imageId={item.imageId}/>
                                </div>
                                <h3>{item.title}</h3>
                                <div className="portfolio__item-actions">
                                    {item.github &&
                                        <SocialLink link={item.github}
                                                    linkType={LinkType.GITHUB}
                                                    text={"Github"}
                                                    className="btn btn-primary"
                                        />
                                    }
                                    {item.demo &&
                                        <SocialLink link={item.demo}
                                                    linkType={LinkType.LIVE_DEMO}
                                                    text="Live Project"
                                                    className="btn btn-primary"
                                        />
                                    }
                                </div>
                            </article>
                        )
                    })}
            </div>
        </section>
    );
}

export default Projects;
