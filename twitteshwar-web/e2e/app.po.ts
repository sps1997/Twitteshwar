import { browser, element, by } from 'protractor';

export class TwitteshwarWebPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('app-root h1')).getText();
  }
}
