UPDATE allergy
SET `group` = 'food'
WHERE name IN ('Coffee', 'Mayonnaise', 'Mustard', 'Sunflower oil', 'Paste', 'Schweppes',
               'Tonic', 'Balms', 'Instant coffee', 'Watermelon', 'Melon', 'Celery',
               'Dill', 'Pepper', 'Anise', 'Raw carrots', 'Beets', 'Garlic', 'Citrus fruits',
               'Bananas', 'Nuts', 'Sesame', 'Seafood', 'Eggs', 'Legumes', 'Milk', 'Cereals',
               'Citrus', 'Honey', 'egg white', 'cow''s milk', 'cod', 'wheat', 'rye', 'barley',
               'oats', 'corn', 'rice', 'buckwheat', 'peanuts', 'soy', 'walnut', 'almonds',
               'shrimp', 'tomato', 'pork', 'veal', 'carrot', 'orange', 'potatoes', 'tuna',
               'salmon', 'strawberry', 'baker''s yeast', 'onion', 'apple',
               'Swiss cheese', 'egg yolk', 'casein', 'chicken', 'kiwi', 'parsley', 'malt',
               'banana', 'cocoa', 'peach', 'avocado', 'Chocolate', 'raspberry', 'milk powder',
               'lemon', 'grapefruit', 'pineapple', 'cabbage', 'Brussels sprouts', 'cinnamon',
               'black tea', 'pumpkin', 'red radish', 'black currant', 'vanilla', 'lentils',
               'apricot', 'cherry', 'cucumber', 'plum', 'squid', 'grapes', 'broccoli', 'asparagus',
               'ginger', 'bay leaf', 'black pepper', 'blueberry', 'pomegranate', 'mandarin',
               'olives', 'nectarine', 'walleye', 'cocksfoot', 'Vermouth');

UPDATE allergy
SET `group` = 'household'
WHERE name IN ('Dust', 'Washing powder', 'Dishwashing liquid', 'latex');

UPDATE allergy
SET `group` = 'pollen'
WHERE name IN ('Sunflower seeds', 'Dandelions', 'timothy pollen', 'alder pollen',
               'birch pollen', 'oak pollen', 'walnut pollen', 'eucalyptus', 'acacia pollen',
               'rye pollen', 'linden pollen', 'ragweed pollen', 'wormwood pollen',
               'rBet v1 birch', 'rBet v2 birch');


UPDATE allergy
SET `group` = 'insect'
WHERE name IN ('Bee venom', 'Wasp poison', 'Hornet venom', 'The poison of ants');

UPDATE allergy
SET `group` = 'medicinal'
WHERE name IN ('Penicillins', 'Sulfonamides', 'Salicylates', 'Mite D. farinae', 'nGal d2 ovalbumin',
               'alpha-lactalbumin', 'beta-lactoglobulin', 'rPhl p1 timothy',
               'rPhl p5 timothy', 'Penicillium notatum', 'Aspergillus fumigatus',
               'Аlternaria alternata', 'Aspergillus niger', 'Local anesthetics',
               'Mite D. pteronossinus');

UPDATE allergy
SET `group` = 'epidermal'
WHERE name IN ('cat epithelium', 'canine epithelium', 'horse epithelium',
               'goose feather', 'sheep wool', 'rabbit epithelium', 'Bovine serum albumin',
               'Parrot feather', 'pigeon feather', 'cockroach');




