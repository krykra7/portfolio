import React from 'react';
import {useApi} from "../../api/common/ApiContext";

function Buttons() {
    const {api} = useApi();

    const downloadFile = () => {
        api.getCVFile()
            .then((resp: Blob) => {
                let url = URL.createObjectURL(resp);
                const link = document.createElement("a");
                link.href = url;
                link.setAttribute("download", "kkrawczyk_resume.pdf");
                link.setAttribute("className", "hidden")
                document.body.append(link);
                link.click();
                URL.revokeObjectURL(url);
                link.remove();
            }).catch(() => {
        });
    }

    return (
        <div className="buttons">
            <button onClick={downloadFile} className="btn btn-cv">Download CV</button>
            <a href="#contact" className="btn btn-primary">Let's Talk</a>
        </div>
    );
}

export default Buttons;
