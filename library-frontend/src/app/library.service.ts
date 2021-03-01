import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from './bookclass/Book'
import {tap, catchError} from 'rxjs/operators';
import {of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {

  baseURL: string = "http://localhost:8080/api"
  httpOptions = {headers: new HttpHeaders({"Content-Type": "application/json"})}
  constructor(private http: HttpClient) { 

  }

  getAllBooks(): Observable<Book[]>{
    return this.http.get<Book[]>(this.baseURL + "/book")
    .pipe(
      tap(x => console.log(x)),
      catchError(err => {
        console.log(err);
        let empty : Book[] = [];
        return of(empty);
      })
    );
  }

  addBook(toAdd: Book) : Observable<Book> {
    return this.http.post<Book>(this.baseURL + "/new", toAdd, this.httpOptions)
    .pipe(
      tap(x => console.log(x)),
      catchError(err => {
        console.log(err);
        return of(null);
      })
    );
  }


}
