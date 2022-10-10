import { TagContentType } from "@angular/compiler";

export class Post {
  id: bigint | null;
  postName: string;
  postPlace: string;
  postLink: string;
  postDescription: string;
  postDateEvent:Date;
  association : Association;
  tag : Tag;


}
