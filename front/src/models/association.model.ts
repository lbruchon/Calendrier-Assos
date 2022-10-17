import { Member } from "./member.model";
import { Post } from "./post.model";

export class Association {
  id: bigint | null;
  associationName: string;
  associationFbLink: string;
  associationIgLink: string;
  // membresAsso: Array<Member>;
  // postsAsso: Array<Post>;


  constructor(
    id: bigint | null,
    associationName: string,
    associationFbLink: string,
    associationIgLink: string
    // membresAsso: Array<Member>,
    // postsAsso: Array<Post>
) {
    this.id = id
    this.associationName = associationName
    this.associationFbLink = associationFbLink
    this.associationIgLink = associationIgLink
    // this.membresAsso = membresAsso
    // this.postsAsso = postsAsso
  }


}
