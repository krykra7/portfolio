import React from 'react';
import {BsPatchCheckFill} from "react-icons/all";
import "./experience.css"
import {SkillGroupResponse} from "../../api/response/SkillGroupResponse";
import {SkillResponse} from "../../api/response/SkillResponse";

type Props = {
    skillGroups: SkillGroupResponse[]
}

function Experience({skillGroups}: Props) {

    const Skill = ({name, level}: SkillResponse) => {
        return (
            <article className="experience__details">
                <BsPatchCheckFill className="experience__details-icon"/>
                <div>
                    <h4>{name}</h4>
                    <small className="text-light">{level}</small>
                </div>
            </article>
        )
    }

    const SkillGroup = ({skills, category}: SkillGroupResponse) => {
        return (
            <div>
                <h3>{category}</h3>
                <div className="experience__content">
                    {skills.map((item, index) => {
                        return <Skill key={index} name={item.name} level={item.level}/>
                    })}
                </div>
            </div>
        );
    }

    return (
        <section id="experience">
            <h5>What Skills I Have</h5>
            <h2>My Experience</h2>

            <div className="container experience__container">
                {skillGroups.map((item, index) => {
                    return <SkillGroup key={index} category={item.category} skills={item.skills}/>
                })}
            </div>
        </section>
    );
}

export default Experience;
