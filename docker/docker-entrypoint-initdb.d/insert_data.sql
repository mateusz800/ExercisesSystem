\connect math

SET SESSION AUTHORIZATION math;

-- test user
--------- email: u1@test.com
--------- password: 123123123
INSERT INTO math.user (email, password) VALUES ('u1@test.com', '$2a$10$XpSGJPkAATJ.O6gQRA4EMO/ZHlXPRbBsaJlTkDon3yTaYMCDkAnuG');


-- roles
INSERT INTO math.role (name, "desc") VALUES ('student', 'User of the mobile application');
INSERT INTO math.role (name, "desc") VALUES ('teacher', 'Has access to creating new courses and exercises');

-- permissions
INSERT INTO math.permissions(user_id, role_name) VALUES (1, 'student');

-- course
INSERT INTO math.course (name, "desc", image) VALUES ('trygonometria', 'Jakis opis', 'http://192.168.1.69:8125/images/course/trygonometry.png');
INSERT INTO math.course (name, "desc", image) VALUES ('geometria', 'Jakis opis', 'http://192.168.1.69:8125/images/course/geometry.png');
INSERT INTO math.course (name, "desc", image) VALUES ('ułamki', 'Jakis opis', 'http://192.168.1.69:8125/images/course/fractions.png');
INSERT INTO math.course (name, "desc", image) VALUES ('funkcje', 'Jakis opis', 'http://192.168.1.69:8125/images/course/functions.png');

-- exercises
 INSERT INTO math.exercise (question, correct_answers, incorrect_answers, course_id, solution)
    VALUES ('Jeżeli sin $\alpha= \frac{4}{5} $ i  $\alpha $ jest kątem ostrym, to:',
    '{ "data":[{"answer":"cos $\\alpha = \\frac{3}{5}$"}]}', '{ "data":[{"answer":"cos $\\alpha = -\\frac{4}{5}$"},{"answer":"cos $\\alpha = -\\frac{3}{5}$"}, {"answer":"cos $\\alpha = -\\frac{9}{25}$"}]}', 1,
     '$sin^{2}\alpha + cos^{2}\alpha = 1  \\\\  cos^{2}\alpha = 1 - sin^{2}\alpha \\\\ cos^{2}\alpha = 1 - \frac{3}{5}^{2} \\\\ cos^{2}\alpha = 1 - \frac{16}{25} = \frac{9}{25} \\\\   \alpha $ jest kątem ostrym, $\\$ więc  $ \underline{cos\alpha = \frac{3}{5}}$');
