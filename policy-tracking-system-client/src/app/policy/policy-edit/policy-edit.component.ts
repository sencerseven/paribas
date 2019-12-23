import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms"
import { PolicyApiService } from 'src/app/services/policy-api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PolicyOutputModel } from 'src/app/model/policy-output.model';
import {first} from "rxjs/operators";

@Component({
  selector: 'app-policy-edit',
  templateUrl: './policy-edit.component.html',
  styleUrls: ['./policy-edit.component.css']
})
export class PolicyEditComponent implements OnInit {
  policy:PolicyOutputModel;
  editForm: FormGroup;
  editPolicyId:number;
  

  constructor(private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private policyApiService: PolicyApiService) { 
      this.editPolicyId= this.route.snapshot.params['id'];
    }

  ngOnInit() {
    this.editForm = this.formBuilder.group({
      id: [''],
      productName: ['', Validators.required],
      productType: ['', Validators.required],
      description: ['', Validators.required],
      expiry: [''],
      total: ['', Validators.required]
    });


   this.policy  = new PolicyOutputModel();
   this.policy.id = this.editPolicyId;
    this.policyApiService.getAllPolicies(this.policy).subscribe(data => {
      if(data.code == 200){
        this.policy = <PolicyOutputModel>data.data;
        console.log(this.policy);
        this.editForm.setValue(this.policy[0]);
        
      }
    });

  }

  onSubmit() {
    this.policyApiService.savePolicy(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          if(data.code == 200) {
            alert('User updated successfully.');
            this.router.navigate(['policy']);
          }else {

          }
        },
        error => {
          alert(error);
        });
  }

}
