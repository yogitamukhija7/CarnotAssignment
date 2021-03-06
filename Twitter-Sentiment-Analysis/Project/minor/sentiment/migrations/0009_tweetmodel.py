# -*- coding: utf-8 -*-
# Generated by Django 1.10.6 on 2017-05-01 16:16
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('sentiment', '0008_delete_tweetmodel'),
    ]

    operations = [
        migrations.CreateModel(
            name='TweetModel',
            fields=[
                ('tweetId', models.IntegerField(primary_key=True, serialize=False)),
                ('topic', models.CharField(max_length=100)),
                ('text', models.CharField(max_length=100)),
                ('date', models.DateTimeField()),
                ('lat', models.FloatField()),
                ('lon', models.FloatField()),
                ('sentiment', models.CharField(max_length=100)),
            ],
        ),
    ]
