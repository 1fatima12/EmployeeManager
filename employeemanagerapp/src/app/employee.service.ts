import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Employee} from './employee'
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private apiServerUrl=environment.apiBaseUrl;
  constructor(private http : HttpClient) { }
  public getEmployees(): Observable<Employee[]>{
    return this.http.get<any>(`${this.apiServerUrl}/api/getAll`)
  }
  public addEmployee(employee : Employee): Observable<Employee>{
    return this.http.post<Employee>(`${this.apiServerUrl}/api/save`,employee)
  }
  public updateEmployee(employeeId:number ,employee : Employee): Observable<Employee>{
    return this.http.put<Employee>(`${this.apiServerUrl}/api/update/${employeeId}`,employee)
  }
  public deleteEmployee(employeeId : number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/delete/${employeeId}`)
  }
}
