import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import axios from 'axios'


const httpOptions = {
  headers: new HttpHeaders({
    "Content-Type": "application/json",
    responseType: 'text'
  })
};
const options = {
  method: 'get',
  url: 'http://localhost:9001/ServletApplication/DataSource',
  data: {
    name: 'Finn',
    lastName: 'Williams'
  }
};
@Injectable({
  providedIn: 'root'
})
export class DataSourceService {
  sort(data): any {
    return axios.post(this.sortUrl, JSON.stringify(data))
  }

  searchRecord(data) {
    axios.get(this.searchUrl).then(res => console.log(res))
    return axios.post(this.searchUrl, JSON.stringify(data))
  }
  searchRecords(data) {
    return axios.post(this.searchMultipleUrl, JSON.stringify(data))
  }

  constructor(private http: HttpClient) { }
  url: any = 'http://localhost:9001/ServletApplication/DataSource';
  searchUrl: any = "http://localhost:9001/ServletApplication/Search";
  searchMultipleUrl:any="http://localhost:9001/ServletApplication/SearchOnMultiple";
  sortUrl: any = "http://localhost:9001/ServletApplication/Sort";
  addRecord(data) {
    let res;
    console.log('fgd')
    console.log(fetch(this.url))
    axios.get(this.url).then(res => console.log(res))
    return axios.post(this.url, JSON.stringify(data))
   
  }
}
