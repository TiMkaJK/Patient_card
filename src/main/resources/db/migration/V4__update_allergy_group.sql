update allergy set `group` = 'food' where name in ('Coffee','Mayonnaise','Mustard','Sunflower oil','Paste','Schweppes',
                                                   'Tonic', 'Balms','Instant coffee','Watermelon','Melon','Celery',
                                                   'Dill','Pepper','Anise','Raw carrots','Beets','Garlic','Citrus fruits',
                                                   'Bananas','Nuts','Sesame','Seafood','Eggs','Legumes','Milk','Cereals',
                                                   'Citrus','Honey','egg white','cow''s milk','cod','wheat','rye','barley',
                                                   'oats','corn','rice','buckwheat','peanuts','soy','walnut','almonds',
                                                   'shrimp','tomato','pork','veal','carrot','orange','potatoes','tuna',
                                                   'salmon','strawberry','baker''s yeast','onion','apple',
                                                   'Swiss cheese','egg yolk','casein','chicken','kiwi','parsley','malt',
                                                   'banana','cocoa','peach','avocado','Chocolate','raspberry','milk powder',
                                                   'lemon','grapefruit','pineapple','cabbage','Brussels sprouts','cinnamon',
                                                   'black tea','pumpkin','red radish','black currant','vanilla','lentils',
                                                   'apricot','cherry','cucumber','plum','squid','grapes','broccoli','asparagus',
                                                   'ginger','bay leaf','black pepper','blueberry','pomegranate','mandarin',
                                                   'olives','nectarine','walleye','cocksfoot', 'Vermouth');

update allergy set `group` = 'household' where name in ('Dust','Washing powder','Dishwashing liquid','latex') ;

update allergy set `group` = 'pollen' where name in ('Sunflower seeds', 'Dandelions','timothy pollen','alder pollen',
                                                     'birch pollen','oak pollen','walnut pollen','eucalyptus','acacia pollen',
                                                     'rye pollen','linden pollen','ragweed pollen','wormwood pollen',
                                                     'rBet v1 birch','rBet v2 birch');


update allergy set `group` = 'insect' where name in ('Bee venom','Wasp poison','Hornet venom','The poison of ants');

update allergy set `group` = 'medicinal' where name in ('Penicillins','Sulfonamides','Salicylates','Mite D. farinae','nGal d2 ovalbumin',
                                                        'alpha-lactalbumin','beta-lactoglobulin','rPhl p1 timothy',
                                                        'rPhl p5 timothy','Penicillium notatum','Aspergillus fumigatus',
                                                        'Аlternaria alternata','Aspergillus niger','Local anesthetics',
                                                        'Mite D. pteronossinus');

update allergy set `group` = 'epidermal' where name in ('cat epithelium','canine epithelium','horse epithelium',
                                                        'goose feather','sheep wool','rabbit epithelium','Bovine serum albumin',
                                                        'Parrot feather','pigeon feather','cockroach');




