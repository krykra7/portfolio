import {LinkType} from "../../api/types/LinkType";
import {useApi} from "../../api/common/ApiContext";
import {FaTwitter} from "react-icons/all";
import React from "react";

type Props = {
    link: string;
    linkType: LinkType;
    text?: string;
    Icon?: JSX.Element;
    className?: string;
}

export default function SocialLink(props: Props) {
    const {api} = useApi();
    const {
        link,
        linkType,
        text,
        Icon,
        className
    } = props;

    const postSocialLog = (linkType: LinkType, linkValue: string) => {
        api.postSocialLog({linkType: linkType, linkValue: linkValue}).then();
    }

    return (
        <a href={link}
           className={className}
           onClick={() => postSocialLog(linkType, link)}
           target="_blank">
            {text ? text : Icon}
        </a>
    )
}
