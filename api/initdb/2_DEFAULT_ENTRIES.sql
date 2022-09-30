
/*INSERT INTO defaultdb.associations (id, association_name, association_fb_link, association_ig_link) VALUES (1, 'Asso1', 'LienFB1', 'LienFB2');*/

/* Association */
/*
INSERT INTO defaultdb.associations (id, association_name, association_fb_link, association_ig_link) VALUES (2, 'Fake BDS', 'LienFB3', 'LienIG2');
INSERT INTO defaultdb.associations (id, association_name, association_fb_link, association_ig_link) VALUES (3, 'Fake BDE', 'LienFB4', 'LienIG3');
INSERT INTO defaultdb.associations (id, association_name, association_fb_link, association_ig_link) VALUES (4, 'Fake BDA', 'LienFB5', 'LienIG4');
INSERT INTO defaultdb.associations (id, association_name, association_fb_link, association_ig_link) VALUES (5, 'Fake BDJ', 'LienFB6', 'LienIG5');
INSERT INTO defaultdb.associations (id, association_name, association_fb_link, association_ig_link) VALUES (6, 'Fake OPJ', 'LienFB7', 'LienIG6');
*/

/* Tag */
/*
INSERT INTO defaultdb.tags (id, tag_name) VALUES (1, 'Évènement');
INSERT INTO defaultdb.tags (id, tag_name) VALUES (2, 'Afterwork');
INSERT INTO defaultdb.tags (id, tag_name) VALUES (3, 'Soirée');
INSERT INTO defaultdb.tags (id, tag_name) VALUES (4, 'Voyage');
INSERT INTO defaultdb.tags (id, tag_name) VALUES (5, 'Sport');
*/

/* Membre */

/*
INSERT INTO defaultdb.members (id, member_email, member_mdp, member_superadmin, asso_id)
VALUES (1, 'john.doe@gmail.com', 'jojo', false, (SELECT id FROM associations WHERE association_name = 'Fake BDS'));

INSERT INTO defaultdb.members (id, member_email, member_mdp, member_superadmin, asso_id)
VALUES (2, 'jason.bourne@gmail.com', 'jamie', false, (SELECT id FROM associations WHERE association_name = 'Fake BDE'));

INSERT INTO defaultdb.members (id, member_email, member_mdp, member_superadmin, asso_id)
VALUES (3, 'honore.fetnat@gmail.com', 'hofet', false, (SELECT id FROM associations WHERE association_name = 'Fake BDA'));

INSERT INTO defaultdb.members (id, member_email, member_mdp, member_superadmin, asso_id)
VALUES (4, 'iam.theone@gmail.com', 'rirififiloulou', false, (SELECT id FROM associations WHERE association_name = 'Fake BDJ'));

INSERT INTO defaultdb.members (id, member_email, member_mdp, member_superadmin, asso_id)
VALUES (5, 'elton.john@gmail.com', 'elvis_presley', false, (SELECT id FROM associations WHERE association_name = 'Fake OPJ'));
*/