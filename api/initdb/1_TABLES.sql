
DROP TABLE posts;

DROP TABLE tags;
DROP TABLE members;
DROP TABLE associations;





create table associations
(
    id bigint auto_increment,
    constraint associations_pk
        primary key (id),
    association_name varchar(255) not null,
    association_fb_link varchar(255) null,
    association_ig_link varchar(255) null
);

create table tags
(
    id bigint auto_increment,
    constraint tags_pk
        primary key (id),
    tag_name varchar(255) not null
);

create table members
(
    id bigint auto_increment,
    constraint members_pk
        primary key (id),
    member_email varchar(255) not null,
    member_mdp varchar(255) not null,
    member_superadmin BOOL,
    asso_id bigint not null references associations (id)
);

create table posts
(
    id bigint auto_increment,
    constraint posts_pk
        primary key (id),
    post_name varchar(255) not null,
    post_place varchar(255) not null,
    post_link varchar(255) not null,
    post_description varchar(255) not null,
    post_date_event varchar(255) not null,
    asso_id bigint not null references associations (id),
    tag_id bigint not null references tags (id)
);