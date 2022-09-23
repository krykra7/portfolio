import React, {FormEvent} from 'react';
import "./contact.css"
import {FaTelegramPlane, FiTwitter, MdOutlineEmail} from "react-icons/all";
import emailjs from '@emailjs/browser';
import {useApi} from "../../api/common/ApiContext";
import {LinkType} from "../../api/types/LinkType";
import SocialLink from "../common/SocialLink";
import {PostSendMessageRequest} from "../../api/request/PostSendMessageRequest";

const SEND_MESSAGE_TEXT = "Send a message";

function Contact() {
    const {api} = useApi();

    const sendEmail = (e: FormEvent) => {
        e.preventDefault();
        const form: HTMLFormElement = e.target as HTMLFormElement;

        api.postSendMessage({
            message: form.elements["message"].value,
            senderEmail: form.elements["email"].value,
            senderName: form.elements["name"].value
        } as PostSendMessageRequest)
            .then(() => {
            }).catch(() => {
        });

        form.reset();
    };

    return (
        <section id="contact">
            <h5>Get In Touch</h5>
            <h2>Contact Me</h2>

            <div className="container contact__container">
                <div className="contact__options">
                    <article className="contact__option">
                        <MdOutlineEmail className="contact__option-icon"/>
                        <h4>Email</h4>
                        <h5>krykra7@gmail.com</h5>
                        <SocialLink link={"mailto:krykra7@gmail.com"}
                                    linkType={LinkType.EMAIL}
                                    text={SEND_MESSAGE_TEXT}/>
                    </article>
                    <article className="contact__option">
                        <FaTelegramPlane className="contact__option-icon"/>
                        <h4>Telegram</h4>
                        <h5>Krystian Krawczyk</h5>
                        <SocialLink link={"https://t.me/kkrawczyk1"}
                                    linkType={LinkType.TELEGRAM}
                                    text={SEND_MESSAGE_TEXT}/>
                    </article>
                    <article className="contact__option">
                        <FiTwitter className="contact__option-icon"/>
                        <h4>Twitter</h4>
                        <h5>Krystian Krawczyk</h5>
                        <SocialLink link={"https://twitter.com/messages/compose?recipient_id=Krystia45869675"}
                                    linkType={LinkType.TWITTER}
                                    text={SEND_MESSAGE_TEXT}/>
                    </article>
                </div>
                <form onSubmit={sendEmail}>
                    <input type="text" name="name" placeholder="Your Full Name" required/>
                    <input type="email" name="email" placeholder="Your Email" required/>
                    <textarea name="message" rows={7} placeholder="Your Message" required/>
                    <button type="submit" className="btn btn-primary">Send Message</button>
                </form>
            </div>
        </section>


    );
}

export default Contact;
