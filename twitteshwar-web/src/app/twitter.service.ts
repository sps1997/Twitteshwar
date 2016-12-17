import {Injectable} from '@angular/core';
import {Jsonp, Http,Headers, RequestOptions} from '@angular/http';
import 'rxjs/Rx';


// Import RxJs required methods
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


@Injectable()
export class TwitterService {


  constructor (private _jsonp: Jsonp, private _http: Http) {}

  tweet(message : any) {
        let body = JSON.stringify({ message });
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

         
    console.log("Posting message " + body + " to service...")
    
    return   this._http.post("/api/postTweet", body, options)
        .map(res => res.json());
  
    }

getTweets (){
   return  this._jsonp.get("/api/tweets?callback=JSONP_CALLBACK").map(res => res.json());; 
  }

  getProfile (){
   return  this._jsonp.get("/api/profile?callback=JSONP_CALLBACK").map(res => res.json());; 
  }

  
  


}
