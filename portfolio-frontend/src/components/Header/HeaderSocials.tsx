import React from 'react';
import {BsLinkedin, FaGithub, FaTwitter} from "react-icons/all";
import SocialLink from "../common/SocialLink";
import {LinkType} from "../../api/types/LinkType";

function HeaderSocials() {
    return (
        <div className="header__socials">
            <SocialLink link={"https://www.linkedin.com/in/krystian-krawczyk-647579169/"}
                        linkType={LinkType.LINKEDIN}
                        Icon={<BsLinkedin/>}/>
            <SocialLink link={"https://github.com/krykra7"}
                        linkType={LinkType.GITHUB}
                        Icon={<FaGithub/>}/>
            <SocialLink link={"https://twitter.com/Krystia45869675"}
                        linkType={LinkType.TWITTER}
                        Icon={<FaTwitter/>}/>
        </div>
    );
}

export default HeaderSocials;
