import { Member } from "./member.model";
import { Post } from "./post.model";

export class Association {
  id: bigint | null;
  associationName: string;
  associationFbLink: string;
  associationIgLink: boolean;
  membresAsso: Array<Member> | null;
  postsAsso: Array<Post> | null;


  constructor(
    id: bigint | null,
    associationName: string,
    associationFbLink: string,
    associationIgLink: boolean,
    membresAsso: Array<Member> | null,
    postsAsso: Array<Post> | null
) {
    this.id = id
    this.associationName = associationName
    this.associationFbLink = associationFbLink
    this.associationIgLink = associationIgLink
    this.membresAsso = membresAsso
    this.postsAsso = postsAsso
  }

}
