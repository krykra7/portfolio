import React, {useEffect, useState} from 'react';
import Header from "../Header/Header";
import Nav from "../Nav/Nav";
import About from "../About/About";
import Experience from "../Experience/Experience";
import Services from "../Services/Services";
import Projects from "../Projects/Projects";
import Contact from "../Contact/Contact";
import Footer from "../Footer/Footer";
import {useApi} from "../../api/common/ApiContext";
import {GetSummaryResponse} from "../../api/response/GetSummaryResponse";


const defaultState: GetSummaryResponse = {
    about: "",
    clientsSummary: "",
    experienceSummary: "",
    projects: [],
    projectsSummary: "",
    serviceGroups: [],
    skillGroups: []
}

function App() {
    const {api} = useApi();
    const [state, setState] = useState(defaultState);

    useEffect(() => {
        window.addEventListener('beforeunload', logLeavePage);
        api.getSummary()
            .then((summary) => {
                setState(summary.data);
            }).catch(() => {
        })

        return () => {
            window.removeEventListener('beforeunload', logLeavePage);
        }
    }, []);

    const logLeavePage = () => {
        api.putEntryLog()
    }

    return (
        <>
            <Header/>
            <Nav/>
            <About about={state.about}
                   clientsSummary={state.clientsSummary}
                   experienceSummary={state.experienceSummary}
                   projectsSummary={state.projectsSummary}/>
            <Experience skillGroups={state.skillGroups}/>
            <Services serviceGroups={state.serviceGroups}/>
            <Projects projects={state.projects}/>
            <Contact/>
            <Footer/>
        </>
    );
}

export default App;
