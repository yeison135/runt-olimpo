import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { OlimpoServiceService } from '../service/olimpo-service.service';
export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

export interface Profesor {
  id: string;
  nombre: string;
  progress: string;
  fruit: string;
}

/** Constants used to fill up our data base. */
const FRUITS: string[] = [
  'blueberry',
  'lychee',
  'kiwi',
  'mango',
  'peach',
  'lime',
  'pomegranate',
  'pineapple',
];
const NAMES: string[] = [
  'Maia',
  'Asher',
  'Olivia',
  'Atticus',
  'Amelia',
  'Jack',
  'Charlotte',
  'Theodore',
  'Isla',
  'Oliver',
  'Isabella',
  'Jasper',
  'Cora',
  'Levi',
  'Violet',
  'Arthur',
  'Mia',
  'Thomas',
  'Elizabeth',
];

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements AfterViewInit, OnInit {
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  isEditable = false;

  profesores = [];

  estudiantes = [];

  asignaturas = [];

  ngOnInit() {

    this.olimpoServiceService.consultarProfesores().subscribe((data: any)=>{
      console.log(data);
      this.profesores = data;
      this.dataSource = new MatTableDataSource(this.profesores);
    }) 

    this.olimpoServiceService.consultarEstudiantes().subscribe((data: any)=>{
      console.log(data);
      this.estudiantes = data;
      this.dataSourceEstudiantes = new MatTableDataSource(this.estudiantes);
    }) 

    this.olimpoServiceService.consultarAsignaturas().subscribe((data: any)=>{
      console.log(data);
      this.asignaturas = data;
      this.dataSourceAsignaturas = new MatTableDataSource(this.asignaturas);
    }) 
   
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required],
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required],
    });
  }

  displayedColumns: string[] = ['id', 'nombre', 'asignatura', 'profesores'];

  displayedColumnsCu: string[] = ['id', 'Docente', 'Materia', 'Curso'];

  dataSource: any;
  dataSourceEstudiantes: any;
  dataSourceAsignaturas: any;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private _formBuilder: FormBuilder, public dialog: MatDialog, private olimpoServiceService :OlimpoServiceService) {
    this.dataSource = new MatTableDataSource(this.profesores);
    this.dataSourceEstudiantes = new MatTableDataSource(this.estudiantes);
    this.dataSourceAsignaturas = new MatTableDataSource(this.asignaturas);
  }

  openDialog() {
    this.dialog.open(HomeComponent);
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;

    this.dataSourceEstudiantes.paginator = this.paginator;
    this.dataSourceEstudiantes.sort = this.sort;

    this.dataSourceAsignaturas.paginator = this.paginator;
    this.dataSourceAsignaturas.sort = this.sort;

  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  applyFilterEstudiantes(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSourceEstudiantes.filter = filterValue.trim().toLowerCase();

    if (this.dataSourceEstudiantes.paginator) {
      this.dataSourceEstudiantes.paginator.firstPage();
    }
  }

  applyFilterAsignaturas(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSourceAsignaturas.filter = filterValue.trim().toLowerCase();

    if (this.dataSourceAsignaturas.paginator) {
      this.dataSourceAsignaturas.paginator.firstPage();
    }
  }

}




