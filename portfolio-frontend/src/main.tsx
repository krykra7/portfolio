import React from 'react'
import './index.css'
import App from "./components/App/App";
import ReactDOM from 'react-dom/client';
import {ApiProvider} from "./api/common/ApiContext";

ReactDOM.createRoot(document.getElementById("root")!).render(
    <ApiProvider>
        <App/>
    </ApiProvider>
)
