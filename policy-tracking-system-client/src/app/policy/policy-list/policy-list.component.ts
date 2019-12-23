import { Component, OnInit } from '@angular/core';
import { PolicyOutputModel } from 'src/app/model/policy-output.model';
import { PolicyApiService } from 'src/app/services/policy-api.service';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-policy-list',
  templateUrl: './policy-list.component.html',
  styleUrls: ['./policy-list.component.css']
})
export class PolicyListComponent implements OnInit {
  public policy: PolicyOutputModel[] = [];
  dataSource;
   displayedColumns: string[] = ['productName', 'productType','description', 'expiry', 'total','action'];

  constructor(private policyApiService:PolicyApiService) {
    policyApiService.newPolicyAdded.subscribe(data => {
      console.log(data);
      this.policy.push(data);
      this.dataSource = new MatTableDataSource(this.policy);
    })
    

   }

  ngOnInit() {
    this.policyApiService.getAllPolicies(new PolicyOutputModel()).subscribe(data => {
      if(data.code == 200){
        this.policy =<PolicyOutputModel[]> data.data;
        console.log(this.policy);
        this.dataSource = new MatTableDataSource(this.policy);
      }
    })
  }

  deletePolicy(id:number){
    this.policyApiService.deletePolicy(id).subscribe(data => {
      if(data.code == 200){
        this.policy = this.policy.filter(item => item.id != id);
        this.dataSource = new MatTableDataSource(this.policy);
        alert ('Silinme işlemi başarılı');
      }else{
        alert ('Başarısız');
      }
    })
  }

}
