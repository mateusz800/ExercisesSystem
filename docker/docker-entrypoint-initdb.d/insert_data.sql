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
INSERT INTO math.permissions(user_id, role_name) VALUES (1, 'teacher');



-- course
INSERT INTO math.course (name, description, image) VALUES ('trygonometria', 'jedynka trygonometryczna $\\\\$ $sin^{2}\alpha + cos^{2}\alpha = 1$ ', 'https://math-user-api.herokuapp.com/images/course/trygonometry.png');
INSERT INTO math.course (name, description, image) VALUES ('stereometria', 'Prostopadłościan: $\\ $ - długości krawędzi: a, b, c$\\ $- pole = 2(ab + bc + ac)$\\ $- objętość = ab$\\ $ Ostrosłup:$\\ $- pole podstawy: P_{p}$\\ $- wysokość: H$\\ $- objętość = $\frac{1}{3}P_{p}H$', 'https://math-user-api.herokuapp.com/images/course/geometry.png');
INSERT INTO math.course (name, description, image) VALUES ('ułamki', 'Jakis opis', 'https://math-user-api.herokuapp.com/images/course/fractions.png');
INSERT INTO math.course (name, description, image) VALUES ('funkcje', 'Jakis opis', 'https://math-user-api.herokuapp.com/images/course/functions.png');
INSERT INTO math.course (name, description, image) VALUES ('probabilistyka', 'Jakis opis', 'https://math-user-api.herokuapp.com/images/course/probability.png');
INSERT INTO math.course (name, description, image) VALUES ('statystyka', 'Jakis opis', 'https://math-user-api.herokuapp.com/images/course/statistics.png');
INSERT INTO math.course (name, description, image) VALUES ('planimetria', 'Jakis opis', 'https://math-user-api.herokuapp.com/images/course/planimetry.png');
INSERT INTO math.course (name, description, image) VALUES ('ciągi liczbowe', 'Jakis opis', 'https://math-user-api.herokuapp.com/images/course/numerical_sequences.png');
INSERT INTO math.course (name, description, image) VALUES ('równania i nierówności', 'Jakis opis', 'https://math-user-api.herokuapp.com/images/course/equations.png');


-- course_author
INSERT INTO math.course_author (course_id, author_id) VALUES (1,1);
INSERT INTO math.course_author (course_id, author_id) VALUES (2,1);
INSERT INTO math.course_author (course_id, author_id) VALUES (3,1);
INSERT INTO math.course_author (course_id, author_id) VALUES (4,1);
INSERT INTO math.course_author (course_id, author_id) VALUES (5,1);
INSERT INTO math.course_author (course_id, author_id) VALUES (6,1);
INSERT INTO math.course_author (course_id, author_id) VALUES (7,1);
INSERT INTO math.course_author (course_id, author_id) VALUES (8,1);
INSERT INTO math.course_author (course_id, author_id) VALUES (9,1);

-- exercises
INSERT INTO math.exercise (question, correct_answers, incorrect_answers, course_id, solution)
    VALUES ('Jeżeli sin $\alpha= \frac{4}{5} $ i  $\alpha $ jest kątem ostrym, to:',
    '{ "data":[{"answer":"cos $\\alpha = \\frac{3}{5}$"}]}', '{ "data":[{"answer":"cos $\\alpha = -\\frac{4}{5}$"},{"answer":"cos $\\alpha = -\\frac{3}{5}$"}, {"answer":"cos $\\alpha = -\\frac{9}{25}$"}]}', 1,
     '$sin^{2}\alpha + cos^{2}\alpha = 1  \\\\  cos^{2}\alpha = 1 - sin^{2}\alpha \\\\ cos^{2}\alpha = 1 - \frac{3}{5}^{2} \\\\ cos^{2}\alpha = 1 - \frac{16}{25} = \frac{9}{25} \\\\   \alpha $ jest kątem ostrym, $\\$ więc  $ \underline{cos\alpha = \frac{3}{5}}$');

INSERT INTO math.exercise (question, correct_answers, incorrect_answers, course_id)
    VALUES ('Trójkąt może mieć tylko jeden kąt prosty',
    '{"data": [{"answer":"Prawda"}]}', '{"data": [{"answer":" Fałsz"}]}', 1);

INSERT INTO math.exercise (question, correct_answers, incorrect_answers, course_id)
    VALUES ('Liczba $sin60^{\degree} +cos60^{\degree} $ jest równa','{"data": [{"answer":"$\\frac{\\sqrt{3} +1}{2}$"}]}',
    '{"data": [{"answer":"$\\frac{\\sqrt{3} +1}{3}$"},{"answer":"$\\frac{2\\sqrt{3} +1}{6}$"},{"answer":" $\\frac{1}{2}$"},{"answer":" $\\frac{\\sqrt{3}}{2}$"},{"answer":"$\\frac{\\sqrt{3}}{4} $"}]}',1);

INSERT INTO math.exercise (question, correct_answers, incorrect_answers, course_id, image)
    VALUES ('W trójkącie, przedstawionym na rysunku powyżej, sinus kąta ostrego $\alpha$ jest równy',
    '{"data": [{"answer":"$\\frac{2\\sqrt{6}}{5}$"}]}', '{"data": [{"answer":" $\\frac{\\sqrt{6}}{12}$"},{"answer":" $\\frac{1}{5}$"},{"answer":"  $\\frac{5}{24}$"}]}', 1, 'https://math-user-api.herokuapp.com/images/exercise/img1.png');

INSERT INTO math.exercise (question, correct_answers, course_id)
    VALUES ('$ tg\alpha ctg\alpha $ jest równe','{"data": [{"answer":1}]}','1');

INSERT INTO math.exercise (question, correct_answers, incorrect_answers, course_id)
    VALUES ('Równanie 2$x^2$ - 4$x$ - 3 = 0:','{"data": [{"answer":"ma dwa rozwiązania"}]}',
	'{"data": [{"answer":"nie ma rozwiązań"},{"answer":"ma jedno rozwiązanie"},{"answer":"ma nieskończenie wiele rozwiązań"}]}',9);

INSERT INTO math.exercise (question, correct_answers, incorrect_answers, course_id)
    VALUES ('Liczba rozwiązań równania $\frac{x^2-5}{5-x}$ = 0, to:','{"data": [{"answer":"2"}]}',
    '{"data": [{"answer":"0"},{"answer":"1"},{"answer":"3"}]}',9);

INSERT INTO math.exercise (question, correct_answers, incorrect_answers, course_id)
    VALUES ('Średnia arytmetyczna siedmiu liczb jest równa 3. Po dołączeniu do nich liczby 11 średnia arytmetyczna tych liczb będzie równa:',
	'{"data": [{"answer":"4"}]}','{"data": [{"answer":"6"},{"answer":"3"},{"answer":"10"}]}',9);

INSERT INTO math.exercise (question, correct_answers, incorrect_answers, course_id)
    VALUES ('Rozwiązaniem równania$\frac{3}{2x-1}$ = 2 jest liczba:','{"data": [{"answer":"1,25"}]}',
	'{"data": [{"answer":"0,5"},{"answer":"-1,25"},{"answer":"1,2"}]}',9);

INSERT INTO math.exercise (question, correct_answers, incorrect_answers, course_id)
    VALUES ('Zbiorem rozwiązań nierówności 2$x^2$ - 8 $>$ 0 jest:','{"data": [{"answer":"(-$\\infty$, -2)u(2, +$\\infty$)"}]}',
    '{"data": [{"answer":"(-$\\infty$, -2$>$u$<$2, +$\\infty$)"},{"answer":"(-2, 2)"},{"answer":"$<$-2, 2$>$"}]}',9);

INSERT INTO math.exercise (question, correct_answers, incorrect_answers, course_id)
    VALUES ('Największa liczba naturalna spełniająca nierówność $\frac{n+15}{n}$ $>$ 3, to:',
	'{"data": [{"answer":"7"}]}','{"data": [{"answer":"8"},{"answer":"6"},{"answer":"nie istnieje"}]}',9);

INSERT INTO math.exercise (question, correct_answers, incorrect_answers, course_id)
    VALUES ('Rozwiązaniem równania $x^2+x=(x+1)^2-7(x+2)$ jest liczba:','{"data": [{"answer":"$-\\frac{13}{6}$"}]}',
    '{"data": [{"answer":"$-\\frac{13}{8}$"},{"answer":"$\\frac{15}{8}$"},{"answer":"$\\frac{15}{6}$"}]}',9);
