import React, {useContext} from "react";
import Api from "./Api";

const ApiContext = React.createContext<{ api: Api } | undefined>(undefined);
type Props = { children: React.ReactNode }


function ApiProvider({children}: Props) {
    const api = {api: new Api()};
    return (
        <ApiContext.Provider value={api}>
            {children}
        </ApiContext.Provider>
    )
}

function useApi() {
    const context = useContext(ApiContext);
    if (context == undefined) {
        throw new Error("context not initialized");
    }

    return context;
}

export {ApiProvider, useApi};

