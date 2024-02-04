create table history
(
    historyId   int auto_increment primary key,
    userId int  not null,
    postId int  not null,
    viewDate varchar(50)  not null
);

INSERT INTO history (userId, postId, viewDate) VALUES (1,1,'2024-02-01 22:31:34');
INSERT INTO history (userId, postId,viewDate) VALUES (1,2,'2024-02-02 22:31:34');
INSERT INTO history (userId, postId,viewDate) VALUES (1,3,'2024-02-03 22:31:34');
INSERT INTO history (userId, postId,viewDate) VALUES (2,2,'2024-02-04 22:31:34');
INSERT INTO history (userId, postId,viewDate) VALUES (2,3,'2024-02-05 22:31:34');
