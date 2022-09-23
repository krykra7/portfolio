import axios, {AxiosInstance, AxiosRequestConfig, AxiosResponse} from "axios";
import {toast} from "react-toastify";
import {GetSummaryResponse} from "../response/GetSummaryResponse";
import {AppFileType} from "../types/AppFileType";
import * as http from "http";
import {PostSocialLogRequest} from "../request/PostSocialLogRequest";
import {Blob} from "buffer";
import {PostSendMessageRequest} from "../request/PostSendMessageRequest";

export default class Api {

    protected readonly configWithCookie: AxiosRequestConfig = {
        withCredentials: true,
        headers: {
            'Content-Type': 'application/json'
        },
    };

    protected readonly fileConfig: AxiosRequestConfig = {
        responseType: "arraybuffer"
    }

    protected readonly cvFileConfig: AxiosRequestConfig = {
        responseType: "blob"
    }

    protected axiosInstance: AxiosInstance;

    constructor() {
        this.axiosInstance = axios.create();

        this.axiosInstance.interceptors.response.use(
            (response) => response,
            (error) => {
                toast.error(error.response.data.message);
                return Promise.reject(error);
            })
    }

    putEntryLog = (): void => {
        fetch(`/api/v1/log/entry`, {
            keepalive: true,
            method: "PUT",
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Credentials': "true"
            },
        }).then(r =>{})
    }

    getSummary = (): Promise<AxiosResponse<GetSummaryResponse>> => {
        return this.axiosInstance.get(`/api/v1/summary`, this.configWithCookie);
    }

    getFileById = (imageId: number): Promise<File> => {
        return this.getFile(`/api/v1/files/${imageId}`);
    }

    getFileByType = (fileType: AppFileType): Promise<File> => {
        return this.getFile(`/api/v1/files/type/${fileType.toString()}`);
    }

    postSocialLog = (request: PostSocialLogRequest) => {
        return this.axiosInstance.post(`/api/v1/log/social`, request, this.configWithCookie);
    }

    postSendMessage = (request: PostSendMessageRequest) => {
        return this.axiosInstance.post(`/api/v1/message`, request, this.configWithCookie);
    }

    async getCVFile(): Promise<Blob> {
        return new Promise<Blob>((resolve, reject) => {
            this.axiosInstance.get(
                `/api/v1/files/type/${AppFileType.CV.toString()}`,
                this.cvFileConfig
            ).then((resp: AxiosResponse<Blob>) => {
                    return resolve(resp.data);
                }
            ).catch((error) => reject(error));
        })
    }

    private getFile = (url: string): Promise<File> => {
        return new Promise<File>((resolve, reject) => {
            this.axiosInstance.get(
                url,
                this.fileConfig
            ).then((resp: AxiosResponse<ArrayBuffer>) => {
                    const contentType = resp.headers["content-type"];
                    const filename = resp.headers["content-disposition"].split('filename=')[1].split(';')[0];
                    return resolve(new File([resp.data], filename, {type: contentType}));
                }
            ).catch((error) => reject(error));
        })
    }
}
