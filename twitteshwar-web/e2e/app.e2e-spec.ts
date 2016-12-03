import { TwitteshwarWebPage } from './app.po';

describe('twitteshwar-web App', function() {
  let page: TwitteshwarWebPage;

  beforeEach(() => {
    page = new TwitteshwarWebPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
