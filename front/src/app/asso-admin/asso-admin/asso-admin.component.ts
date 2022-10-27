import { Component, OnInit } from '@angular/core';
import { AssoService } from 'src/app/services/asso.service';
import { MemberService } from 'src/app/services/member.service';
import { PostService } from 'src/app/services/post.service';
import { Association } from 'src/models/association.model';

@Component({
  selector: 'app-asso-admin',
  templateUrl: './asso-admin.component.html',
  styleUrls: ['./asso-admin.component.scss']
})
export class AssoAdminComponent implements OnInit {
  posts : any;
  memberID : any;
  constructor(private postService : PostService, private assoService : AssoService, private memberService : MemberService) {}

  ngOnInit(): void {
    console.log("Page chargée")
      console.log("Member id local storage = ", localStorage['number']);

      var newInt = +localStorage['number'];

      console.log("member id = ", newInt)
      this.assoService.getAllPostOfAnAssoByMemberId(newInt).subscribe(response => this.posts = response)

  }

}
