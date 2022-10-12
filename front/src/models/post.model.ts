import { Association } from './association.model';
import { Tag } from './tag.model';

export class Post {
  id: bigint | null;
  postName: string;
  postPlace: string;
  postLink: string;
  postDescription: string;
  postDateEvent: string;
  association: Association;
  tag: Tag;

  constructor(
    id: bigint | null,
    postName: string,
    postPlace: string,
    postLink: string,
    postDescription: string,
    postDateEvent: string,
    association: Association,
    tag: Tag
  ) {
    this.id = id;
    this.postName = postName;
    this.postPlace = postPlace;
    this.postLink = postLink;
    this.postDescription = postDescription;
    this.postDateEvent = postDateEvent;
    this.association = association;
    this.tag = tag;
  }
}
