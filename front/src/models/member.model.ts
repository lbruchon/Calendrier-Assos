//member.model.ts
export class Member {
  id: bigint | null;
  memberEmail: string;
  memberMdp: string;
  memberSuperAdmin: boolean;
  association: number;

  constructor(id: bigint | null, memberEmail: string, memberMdp: string, memberSuperAdmin: boolean, association: number) {
    this.id = id;
    this.memberEmail = memberEmail;
    this.memberMdp = memberMdp;
    this.memberSuperAdmin = memberSuperAdmin;
    this.association = association;
  }
}
