SELECT 'Initializes MySQL database with data provided below';

INSERT IGNORE INTO emedicare_user (`user_id`, `username`, `type`, `password`, `date_modified`, `date_created`) VALUES (1, 'admin@mail.com', 'admin', 'admin', NOW(), NOW());
INSERT IGNORE INTO emedicare_user (`user_id`, `username`, `type`, `password`, `date_modified`, `date_created`) VALUES (2, 'foo@bar.com', 'admin', 'foo', NOW(), NOW());
INSERT IGNORE INTO emedicare_user (`user_id`, `username`, `type`, `password`, `date_modified`, `date_created`) VALUES (3, 'user@mail.com', 'user', 'user', NOW(), NOW());
INSERT IGNORE INTO emedicare_user (`user_id`, `username`, `type`, `password`, `date_modified`, `date_created`) VALUES (4, 'user@example.com', 'user', 'user', NOW(), NOW());
INSERT IGNORE INTO emedicare_user (`user_id`, `username`, `type`, `password`, `date_modified`, `date_created`) VALUES (5, 'admin@yahoo.com', 'admin', 'admin', NOW(), NOW());
INSERT IGNORE INTO emedicare_user (`user_id`, `username`, `type`, `password`, `date_modified`, `date_created`) VALUES (6, 'user@gmail.com', 'user', 'user', NOW(), NOW());
INSERT IGNORE INTO emedicare_user (`user_id`, `username`, `type`, `password`, `date_modified`, `date_created`) VALUES (7, 'user@outlook.com', 'user', 'user', NOW(), NOW());
INSERT IGNORE INTO emedicare_user (`user_id`, `username`, `type`, `password`, `date_modified`, `date_created`) VALUES (8, 'admin@sample.com', 'admin', 'admin', NOW(), NOW());
