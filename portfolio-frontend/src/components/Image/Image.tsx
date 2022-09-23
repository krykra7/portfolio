import {useApi} from "../../api/common/ApiContext";
import {AppFileType} from "../../api/types/AppFileType";
import {useEffect, useState} from "react";

type Props = {
    type?: AppFileType;
    imageId?: number;
}

export default function Image({type, imageId}: Props) {
    const {api} = useApi();
    const [imageUrl, setImageUrl] = useState("");

    useEffect(() => {
        let url: string;

        if (type) {
            api.getFileByType(type)
                .then((resp: File) => {
                    url = URL.createObjectURL(resp);
                    setImageUrl(url);
                })
                .catch(() => {
                });
        } else if (imageId) {
            api.getFileById(imageId)
                .then((resp: File) => {
                    url = URL.createObjectURL(resp);
                    setImageUrl(url);
                })
                .catch(() => {
                });
        }

        return () => {
            URL.revokeObjectURL(url);
        };
    }, [type, imageId])

    return (
        <img src={imageUrl} alt="" loading={"lazy"}/>
    )
}

