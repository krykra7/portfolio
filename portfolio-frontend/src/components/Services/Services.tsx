import React from 'react';
import "./services.css"
import {BiCheck} from "react-icons/all";
import {ServiceGroupResponse} from "../../api/response/ServiceGroupResponse";
import {ServiceResponse} from "../../api/response/ServiceResponse";
import {useApi} from "../../api/common/ApiContext";

type Props = {
    serviceGroups: ServiceGroupResponse[];
}

function  Services({serviceGroups}: Props) {

    const Service = ({name}: ServiceResponse) => {
        return (
            <li>
                <BiCheck className="service__list-icon"/>
                <p>{name}</p>
            </li>
        );
    }

    const ServiceGroup = ({title, services}: ServiceGroupResponse) => {
        return (
            <article className="service">
                <div className="service__head">
                    <h3>{title}</h3>
                </div>
                <ul className="service__list">
                    {services.map((item, index) => {
                        return <Service name={item.name} key={index}/>
                    })}
                </ul>
            </article>
        )
    }

    return (
        <section id="services">
            <h5>What I Offer</h5>
            <h2>Services</h2>

            <div className="container services__container">
                {serviceGroups.map((item, index) => {
                    return <ServiceGroup title={item.title} services={item.services} key={index}/>
                })}
            </div>
        </section>
    );
}

export default Services;
