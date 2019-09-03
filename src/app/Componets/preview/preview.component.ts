import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { DataSourceService } from 'src/app/data-source.service';

@Component({
  selector: 'app-preview',
  templateUrl: './preview.component.html',
  styleUrls: ['./preview.component.css']
})
export class PreviewComponent implements OnInit {
 
  response: any;

  constructor(private fb: FormBuilder, private dataSource: DataSourceService) { }

  ngOnInit() {
  }
  Type: any = ['name', 'email', 'college', 'pno']

  PreviewForm = this.fb.group({
    name: [''],
    type: ['']

  })
  
  SearchForm = this.fb.group({
       type: ['']

  })
  SearchForm2 = this.fb.group({
    name: [''],
    college: ['']

})
  changeProperty(e) {
    console.log(e.value)
    this.type.setValue(e.target.value, {
      onlySelf: true
    })
  }
  changeSelect(e) {
    console.log(e.value)
    this.type.setValue(e.target.value, {
      onlySelf: true
    })
  }
  get type() {
    return this.PreviewForm.get('type');
  }
  setResponce(r){
     console.log("In Set"+r);
     this.response=r;
     console.log(this.response);
  }
  onSubmit() {
    console.log("akjsdnbkj")
    this.dataSource.searchRecord(this.PreviewForm.value).then(res=> this.setResponce(res.data));
    // console.log("Response "+this.re)
  }


  onSort(){
    console.log("SOrt");
    this.dataSource.sort(this.SearchForm.value).then(res=> this.setRes(res.data));
  }

  onSearch(){
    this.dataSource.searchRecords(this.SearchForm2.value).then(res=>this.setSearchValue(res.data));
  }
  SearchValue:any;
  setSearchValue(data: any) {
   
    this.SearchValue=data;
  }


  sort :string;
  strings:any[];
  setRes(r){
    console.log("In Set"+r);
    this.sort=r;
    console.log(this.response);
    this.strings=this.sort.split('&');
 }
}
