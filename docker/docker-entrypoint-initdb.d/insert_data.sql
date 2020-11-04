\connect math

SET SESSION AUTHORIZATION math;

-- course
INSERT INTO math.course (name, "desc", image) VALUES ('trygonometria', 'Jakis opis', 'http://192.168.1.69:8125/images/course/trygonometry.png');
INSERT INTO math.course (name, "desc", image) VALUES ('geometria', 'Jakis opis', 'http://192.168.1.69:8125/images/course/geometry.png');
INSERT INTO math.course (name, "desc", image) VALUES ('ułamki', 'Jakis opis', 'http://192.168.1.69:8125/images/course/fractions.png');
INSERT INTO math.course (name, "desc", image) VALUES ('funkcje', 'Jakis opis', 'http://192.168.1.69:8125/images/course/functions.png');

-- exercises
 INSERT INTO math.exercise (question, correct_answers, incorrect_answers, topic_name, solution)
    VALUES ('Jeżeli sin $\alpha= \frac{4}{5} $ i  $\alpha $ jest kątem ostrym, to:', '{ "data":[{"answer":"cos $\\alpha = -\\frac{1}{5}$"}]}', '{ "data":[{"answer":"cos $\\alpha = -\\frac{3}{5}$"},{"answer":"cos $\\alpha = \\frac{3}{5}$"}, {"answer":"cos $\\alpha = -\\frac{9}{25}$"}]}', 'trygonometria', NULL);
