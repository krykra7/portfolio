INSERT INTO `portfolio`.`summary` (revision, about, experience_summary, clients_summary, projects_summary)
VALUES (1,
        'Hello, I''m Krystian, from the perspective of my professional life I would call myself Full Stack
                        developer
                        mostly experienced in Spring Boot and React. I am currently employed as a Java developer, so I
                        develop my
                        backend skills during working hours. During my 5+ years experience I''ve been working in projects
                        that was
                        using a
                        wide range of technologies which gave me skills and confidence to deliver projects from scratch
                        to working
                        solutions. The more I code and choose more ambitious tasks, the more I''m passionate about
                        technology.
                        If you want your project to be made with due commitment and passion, Contact Me!
                        <br/>
                        <br/>
                        In private Life I''m very involved in sport, my great life passion that gives me peace of mind is
                        Capoeira,
                        which I am an instructor. I love travelling, dancing and to experience wonders of life. I would
                        call myself
                        a collector of experiences. Let me get another one by working with you!',
        '5+ Years Working',
        'Public and Private Sectors',
        '9+ Challenging Projects');

INSERT INTO `portfolio`.`skill_group` (category, summary_id)
VALUES ('FRONTEND', (SELECT id FROM portfolio.summary WHERE revision = 1));

INSERT INTO `portfolio`.`skill_group` (category, summary_id)
VALUES ('BACKEND', (SELECT id FROM portfolio.summary WHERE revision = 1));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('Typescript', 'EXPERIENCED', (SELECT id FROM portfolio.skill_group WHERE category = 'FRONTEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('React', 'EXPERIENCED', (SELECT id FROM portfolio.skill_group WHERE category = 'FRONTEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('Javascript', 'INTERMEDIATE', (SELECT id FROM portfolio.skill_group WHERE category = 'FRONTEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('CSS', 'INTERMEDIATE', (SELECT id FROM portfolio.skill_group WHERE category = 'FRONTEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('HTML', 'EXPERIENCED', (SELECT id FROM portfolio.skill_group WHERE category = 'FRONTEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('Angular', 'BASIC', (SELECT id FROM portfolio.skill_group WHERE category = 'FRONTEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('Nginx', 'INTERMEDIATE', (SELECT id FROM portfolio.skill_group WHERE category = 'FRONTEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('MUI', 'EXPERIENCED', (SELECT id FROM portfolio.skill_group WHERE category = 'FRONTEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('Java', 'EXPERIENCED', (SELECT id FROM portfolio.skill_group WHERE category = 'BACKEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('Spring Boot', 'EXPERIENCED', (SELECT id FROM portfolio.skill_group WHERE category = 'BACKEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('SQL', 'EXPERIENCED', (SELECT id FROM portfolio.skill_group WHERE category = 'BACKEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('Junit', 'INTERMEDIATE', (SELECT id FROM portfolio.skill_group WHERE category = 'BACKEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('NoSQL', 'INTERMEDIATE', (SELECT id FROM portfolio.skill_group WHERE category = 'BACKEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('Docker', 'BASIC', (SELECT id FROM portfolio.skill_group WHERE category = 'BACKEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('Maven', 'EXPERIENCED', (SELECT id FROM portfolio.skill_group WHERE category = 'BACKEND'));

INSERT INTO `portfolio`.`skill` (name, level, skill_group_id)
VALUES ('Microservices', 'INTERMEDIATE', (SELECT id FROM portfolio.skill_group WHERE category = 'BACKEND'));

INSERT INTO `portfolio`.`service_group` (title, summary_id)
VALUES ('Frontend Development', (SELECT id FROM portfolio.summary WHERE revision = 1));

INSERT INTO `portfolio`.`service_group` (title, summary_id)
VALUES ('Backend Development', (SELECT id FROM portfolio.summary WHERE revision = 1));

INSERT INTO `portfolio`.`service_group` (title, summary_id)
VALUES ('Server Administration', (SELECT id FROM portfolio.summary WHERE revision = 1));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Create backend application conception based on your requirements',
        (SELECT id FROM portfolio.service_group WHERE title = 'Backend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Database structure design from scratch',
        (SELECT id FROM portfolio.service_group WHERE title = 'Backend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Implementation using technologies that best meet the needs your requirements',
        (SELECT id FROM portfolio.service_group WHERE title = 'Backend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Secure your service with technologies such as JWT or OAuth',
        (SELECT id FROM portfolio.service_group WHERE title = 'Backend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Refactor and modernize existing apps written in Java',
        (SELECT id FROM portfolio.service_group WHERE title = 'Backend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Deploy and maintain finished applications',
        (SELECT id FROM portfolio.service_group WHERE title = 'Backend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Design and implement architecture for your service',
        (SELECT id FROM portfolio.service_group WHERE title = 'Backend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Create website conception based on your requirements',
        (SELECT id FROM portfolio.service_group WHERE title = 'Frontend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Design flow of the website', (SELECT id FROM portfolio.service_group WHERE title = 'Frontend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Design and implement UX model of website',
        (SELECT id FROM portfolio.service_group WHERE title = 'Frontend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Create whole website implementation',
        (SELECT id FROM portfolio.service_group WHERE title = 'Frontend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Connect your website with backend services',
        (SELECT id FROM portfolio.service_group WHERE title = 'Frontend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Develop or improve your existing website',
        (SELECT id FROM portfolio.service_group WHERE title = 'Frontend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Deployment and maintenance of finished website',
        (SELECT id FROM portfolio.service_group WHERE title = 'Frontend Development'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Maintain, Deploy and service applications hosted on linux servers',
        (SELECT id FROM portfolio.service_group WHERE title = 'Server Administration'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Deploy production bundled static files on linux server',
        (SELECT id FROM portfolio.service_group WHERE title = 'Server Administration'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Make your website available on chosen domain',
        (SELECT id FROM portfolio.service_group WHERE title = 'Server Administration'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Secure your application with SSL certificate (HTTPS)',
        (SELECT id FROM portfolio.service_group WHERE title = 'Server Administration'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Dockerize you application and deploy it',
        (SELECT id FROM portfolio.service_group WHERE title = 'Server Administration'));

INSERT INTO `portfolio`.`service` (name, service_group_id)
VALUES ('Deploy and configure backend and frontend applications together',
        (SELECT id FROM portfolio.service_group WHERE title = 'Server Administration'));

INSERT INTO `portfolio`.`file` (filename, file_type)
VALUES ('Resume.pdf', 'CV');

INSERT INTO `portfolio`.`file` (filename, file_type)
VALUES ('me.jpg', 'MAIN_PHOTO');

INSERT INTO `portfolio`.`file` (filename, file_type)
VALUES ('me-about.jpg', 'ABOUT_ME_PHOTO');

INSERT INTO `portfolio`.`file` (filename, file_type)
VALUES ('CSO.jpg', 'OTHER');

INSERT INTO `portfolio`.`file` (filename, file_type)
VALUES ('herbs.png', 'OTHER');

INSERT INTO `portfolio`.`file` (filename, file_type)
VALUES ('PUE.jpg', 'OTHER');

INSERT INTO `portfolio`.`file` (filename, file_type)
VALUES ('SHRIMP.jpg', 'OTHER');

INSERT INTO `portfolio`.`file` (filename, file_type)
VALUES ('SODIR.jpg', 'OTHER');

INSERT INTO `portfolio`.`file` (filename, file_type)
VALUES ('venues.png', 'OTHER');

INSERT INTO `portfolio`.`file` (filename, file_type)
VALUES ('portfolio.png', 'OTHER');

INSERT INTO `portfolio`.`project` (github, demo, title, description, image_id, summary_id)
VALUES ('https://github.com/krykra7/venues-frontend',
        null,
        'Venues - Engineers Project',
        'Tech stack: Java 8, Spring Boot, Netflix Eureka, Netflix Ribbon, Netflix Zuul, Feign, JWT Authentication, Angular 7, PostgreSQL, Gradle.',
        (SELECT id FROM portfolio.file WHERE filename = 'venues.png'),
        (SELECT id FROM portfolio.summary WHERE revision = 1));

INSERT INTO `portfolio`.`project` (github, demo, title, description, image_id, summary_id)
VALUES (null,
        'https://carolinascienceonline.com/#/',
        'Carolina Science Online',
        'Tech stack: Java 11, Spring Boot, RxJava, Vert.x, MySQL, MongoDB, Junit 5, Junit 4, Mockito, Maven, Jenkins, Microservices, Elastic Search, H2, Liquibase.',
        (SELECT id FROM portfolio.file WHERE filename = 'CSO.jpg'),
        (SELECT id FROM portfolio.summary WHERE revision = 1));

INSERT INTO `portfolio`.`project` (github, demo, title, description, image_id, summary_id)
VALUES (null,
        'https://shrimp.uokik.gov.pl/#/login',
        'SHRIMP 2',
        'Tech Stack: Java 8, Spring Framework, Spring Boot, Javascript, React, PrimeReact, Maven.',
        (SELECT id FROM portfolio.file WHERE filename = 'SHRIMP.jpg'),
        (SELECT id FROM portfolio.summary WHERE revision = 1));

INSERT INTO `portfolio`.`project` (github, demo, title, description, image_id, summary_id)
VALUES (null,
        'https://sod.pfron.org.pl/',
        'SODIR',
        'Tech Stack: Java 7/8, GWT, Javascript, Spring Framework, MySQL, Docker, Maven.',
        (SELECT id FROM portfolio.file WHERE filename = 'SODIR.jpg'),
        (SELECT id FROM portfolio.summary WHERE revision = 1));

INSERT INTO `portfolio`.`project` (github, demo, title, description, image_id, summary_id)
VALUES (null,
        'https://www.zus.pl/pue',
        'ZUS PUE',
        'Tech Stack: Java 7/8, Spring Framework, Spring Boot, Maven, MS SQL, PostgreSQL, Javascript, Freemarker, Software AG, Webservices.',
        (SELECT id FROM portfolio.file WHERE filename = 'PUE.jpg'),
        (SELECT id FROM portfolio.summary WHERE revision = 1));

INSERT INTO `portfolio`.`project` (github, demo, title, description, image_id, summary_id)
VALUES (null,
        'https://herbs.kkrawczyk.info',
        'Alternative medicine learning tool',
        'Tech stack: Java 11, Spring Boot, PostgreSQL, Maven, React, React Hooks, MUI React, Junit 5, H2, Typescript, Nginx, Linux, JWT, Mockito.',
        (SELECT id FROM portfolio.file WHERE filename = 'herbs.png'),
        (SELECT id FROM portfolio.summary WHERE revision = 1));

INSERT INTO `portfolio`.`project` (github, demo, title, description, image_id, summary_id)
VALUES ('https://github.com/krykra7/portfolio',
        'https://krystian-krawczyk.com/',
        'This portfolio application',
        'Tech stack frontened: React, React Hooks, Typescript, Nginx, Vite.js, Axios, Docker, Java 11, Spring Boot, MySQL, Maven, Junit 5, H2, Nginx, Linux, Mockito, Liquibase, Spring mail',
        (SELECT id FROM portfolio.file WHERE filename = 'portfolio.png'),
        (SELECT id FROM portfolio.summary WHERE revision = 1));
