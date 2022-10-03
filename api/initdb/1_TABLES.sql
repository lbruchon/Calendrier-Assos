
DROP TABLE posts;

DROP TABLE tags;
DROP TABLE members;
DROP TABLE associations;





create table associations
(
    id bigint auto_increment,
    constraint associations_pk
        primary key (id),
    association_name TEXT not null,
    association_fb_link TEXT null,
    association_ig_link TEXT null
);

create table tags
(
    id bigint auto_increment,
    constraint tags_pk
        primary key (id),
    tag_name TEXT not null
);

create table members
(
    id bigint auto_increment,
    constraint members_pk
        primary key (id),
    member_email TEXT not null,
    member_mdp TEXT not null,
    member_superadmin BOOL,
    asso_id bigint not null references associations (id)
);

create table posts
(
    id bigint auto_increment,
    constraint posts_pk
        primary key (id),
    post_name TEXT not null,
    post_place TEXT not null,
    post_link TEXT not null,
    post_description TEXT not null,
    post_date_event DATE not null,
    asso_id bigint not null references associations (id),
    tag_id bigint not null references tags (id)
);