import { TagContentType } from "@angular/compiler";

export class Post {
  id: bigint | null;
  postName: string;
  postPlace: string;
  postLink: string;
  postDescription: string;
  postDateEvent:Date;
  associationName : string;
  tagName: string

  constructor(id: bigint | null, postName: string,  postPlace: string, postLink: string, postDescription: string, postDateEvent:Date, associationName : string,tagName: string) {
    this.id = id;
    this.postName = postName;
    this.postPlace=postPlace;
    this.postLink=postLink;
    this.postDescription = postDescription;
    this.postDateEvent=postDateEvent;
    this.associationName=associationName;
    this.tagName = tagName;
  }

}
