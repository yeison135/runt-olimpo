import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OlimpoServiceService {

  private REST_API_SERVER = "http://localhost:8080/olimpo";

  constructor(private httpClient: HttpClient) { }

  public consultarProfesores(){
    return this.httpClient.get(this.REST_API_SERVER + "/profesores");
  }

  public consultarAsignaturas(){
    return this.httpClient.get(this.REST_API_SERVER + "/asignaturas");
  }

  public consultarEstudiantes(){
    return this.httpClient.get(this.REST_API_SERVER + "/estudiantes");
  }

}
