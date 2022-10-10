import { Post } from "./post.model";

export class Tag {
  id: bigint | null;
  tagName: string;
  postTag: Post;


  constructor(id: bigint | null, tagName: string, postTag: Post) {
    this.id = id;
    this.tagName = tagName;
    this.postTag = postTag;
  }
}
