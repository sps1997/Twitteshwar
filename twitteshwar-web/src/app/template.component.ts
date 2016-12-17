import { Component, Input } from '@angular/core';
import { TwitterService } from './twitter.service';
import { OnInit, OnChanges } from '@angular/core';

@Component({
    selector : 'homeTemplate',
    templateUrl : './template.component.html'
})
export class TemplateComponent implements OnInit {
    tweetMessage : string;
    characterLeft: any;    
    
    userProfile : any;
    tweets : Array<Object>;
    
    @Input() userName;

    constructor (private twitterService : TwitterService) {
            this.twitterService.getProfile().subscribe(user => {
            this.userProfile = user.name;
            console.log('printing...')
            console.log(this.userProfile);
        });

    }

    ngOnInit(): void {
    
       this.twitterService.getTweets().subscribe(res => {
            this.tweets = res;
        });
        console.log('got response -- '+ this.tweets);
    }



    tweet() {
        console.log('Message = '+this.tweetMessage);
        this.twitterService.tweet(this.tweetMessage).subscribe(
            () => {console.log('OK done thankyou')}
            ,  err => {console.log (err)}

            );
    }

    validateLength() {
        this.characterLeft = (165 - this.tweetMessage.length);
        console.log(165 - this.tweetMessage.length);
    }
    
    /*ngOnChanges(tweetMessage): void {
        this.characterLeft = (165 - (this.tweetMessage.length ? 0 : this.tweetMessage.length));   
    }*/
}